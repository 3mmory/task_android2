import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication5.DetailActivity
import com.example.myapplication5.databinding.ItemUserBinding
import com.example.myapplication5.databinding.ItemUserAlternateBinding
import androidx.recyclerview.widget.DiffUtil

class UserAdapter : ListAdapter<User, RecyclerView.ViewHolder>(UserDiffCallback()) {

    private val VIEW_TYPE_ONE = 1
    private val VIEW_TYPE_TWO = 2

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    // Implement deletion logic here if needed
                }
            }

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    val context = binding.root.context
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("EXTRA_NAME", user.name)
                        putExtra("EXTRA_EMAIL", user.email)
                        putExtra("EXTRA_PHONE", user.phone)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

    inner class UserAlternateViewHolder(val binding: ItemUserAlternateBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    // Implement deletion logic here if needed
                }
            }

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    val context = binding.root.context
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("EXTRA_NAME", user.name)
                        putExtra("EXTRA_EMAIL", user.email)
                        putExtra("EXTRA_PHONE", user.phone)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            UserViewHolder(binding)
        } else {
            val binding = ItemUserAlternateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            UserAlternateViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = getItem(position)
        if (holder is UserViewHolder) {
            holder.binding.apply {
                userName.text = user.name
                userEmail.text = user.email
                userPhone.text = user.phone
            }
        } else if (holder is UserAlternateViewHolder) {
            holder.binding.apply {
                userName.text = user.name
                userEmail.text = user.email
                userPhone.text = user.phone
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
