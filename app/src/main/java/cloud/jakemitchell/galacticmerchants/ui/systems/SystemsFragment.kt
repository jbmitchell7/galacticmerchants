package cloud.jakemitchell.galacticmerchants.ui.systems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cloud.jakemitchell.galacticmerchants.databinding.FragmentSystemsBinding

class SystemsFragment : Fragment() {
    private var _binding: FragmentSystemsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val systemsViewModel =
            ViewModelProvider(this)[SystemsViewModel::class.java]

        _binding = FragmentSystemsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.lifecycleOwner = this
        binding.systemsViewModel = systemsViewModel
        binding.locationCardList.adapter = SystemsAdapter { location ->
            systemsViewModel.viewSystemLocations(systemsViewModel.token, "OE")
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}