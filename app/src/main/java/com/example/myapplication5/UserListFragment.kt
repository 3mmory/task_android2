import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication5.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Initial data setup
        val users = mutableListOf(
            User("1", "Amr", "alice@example.com", "+123456789", 1),
            User("2", "Bob", "bob@example.com", "+987654321", 2),
            User("3", "Charlie", "charlie@example.com", "+1122334455", 1),
            User("4", "Omar", "omar@example.com", "+123456789", 2),
            User("5", "Mahmoud", "mahmoud@example.com", "+987654321", 1),
            User("6", "Charlie Brown", "charliebrown@example.com", "+1122334455", 2)
        )
        adapter.submitList(users)

        binding.btnUpdate.setOnClickListener {
            // Simulate new data
            val newUsers = listOf(
                User("1", "Amira", "alice@example.com", "+123456789", 1),
                User("2", "mariam ", "bob@example.com", "+987654321", 2),
                User("3", "mona ", "charlie@example.com", "+1122334455", 1),
                User("4", " alaa", "omar@example.com", "+123456789", 2),
                User("5", " nada", "mahmoud@example.com", "+987654321", 1),
                User("6", " hoda ", "charliebrown@example.com", "+1122334455", 2)
            )
            adapter.submitList(newUsers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
