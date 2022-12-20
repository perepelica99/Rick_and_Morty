package com.example.rick_and_morty.data.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import com.example.rick_and_morty.data.adapters.EpisodesAdapter
import com.example.rick_and_morty.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@ExperimentalCoroutinesApi
@FlowPreview
class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    private var episodesAdapter: EpisodesAdapter = EpisodesAdapter()

    private var episode: String? = null

    @Inject
    lateinit var episodesViewModelProvider: EpisodesViewModelProvider
    private lateinit var vm: EpisodesViewModel

    companion object {
        private const val KEY_EPISODE: String = "KEY_EPISODE"

        @JvmStatic
        fun newInstance(
            episode: String?,
        ) =
            EpisodesFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_EPISODE, episode)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(
            this,
            episodesViewModelProvider
        )[EpisodesViewModel::class.java]

        initRecyclerView()
        collectUiState()

        if (episode != null) vm.filteredTrigger.value["episode"] = episode

        setUpSwipeToRefresh()

        binding.btnFilterEpisodes.setOnClickListener {
            navigator().openEpisodesFilterFragment()
        }

        binding.searchEpisodes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                performSearchEvent(query = newText)
                return false
            }

        })
        observeVM()
    }

    private fun observeVM() {

        lifecycle.coroutineScope.launch {
            vm.filteredTrigger.collect {
                vm.getEpisodeByParams(
                    name = vm.filteredTrigger.value.getValue("name"),
                    episode = vm.filteredTrigger.value.getValue("episode"),
                )
            }
        }

        lifecycleScope.launch {
            episodesAdapter.loadStateFlow.collectLatest { loadStates ->
                binding.progressBarEpisodes.isVisible = loadStates.refresh is LoadState.Loading

            }
        }

    }

    private fun performSearchEvent(query: String) {
//        vm.getEpisodes(name = query, episode = episode)
    }

    private fun initRecyclerView() {
        with(binding.rvEpisodes) {
            layoutManager = LinearLayoutManager(requireContext())
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = episodesAdapter
        }
        episodesAdapter.onEpisodeItem = { navigator().openEpisodesDetailFragment(it.id) }
    }

    private fun setUpSwipeToRefresh() {
        binding.swipeRefreshEpisodes.apply {
            setOnRefreshListener {
                vm.getEpisodeByParams(null, null)
                binding.swipeRefreshEpisodes.isRefreshing = false
                binding.rvEpisodes.scrollToPosition(0)
            }
        }
    }

    private fun collectUiState() {

        viewLifecycleOwner.lifecycleScope.launch {
            vm.episodesFlow.collectLatest  { episodesAdapter.submitData(it) }
        }
    }

    private fun init() {
        arguments?.let {
            episode = it.getString(KEY_EPISODE)
        }
    }
}