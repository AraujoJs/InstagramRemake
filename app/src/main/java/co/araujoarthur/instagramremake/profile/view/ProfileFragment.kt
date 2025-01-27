package co.araujoarthur.instagramremake.profile.view

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val rv = binding?.rvProfile

        rv?.layoutManager = GridLayoutManager(requireContext(), 3)
        rv?.adapter = PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        return inflater.inflate(R.menu.menu_profile_main, menu)
    }

    private class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            return PostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_profile_grid, parent, false)
            )
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            holder.bind(R.drawable.no_image)
        }

        override fun getItemCount(): Int {
            return 30
        }

        inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(imageId: Int) {
                itemView.findViewById<ImageView>(R.id.item_profile_image_grid).setImageResource(imageId)
            }
        }

    }

}