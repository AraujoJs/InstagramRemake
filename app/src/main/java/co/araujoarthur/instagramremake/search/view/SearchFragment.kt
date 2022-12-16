package co.araujoarthur.instagramremake.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.araujoarthur.instagramremake.R
import de.hdodenhof.circleimageview.CircleImageView

class SearchFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rv_search_users)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = ProfileAdapter()
    }

    private class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
            return ProfileViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_search_profile, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
        }

        override fun getItemCount(): Int {
            return 30
        }

        private inner class ProfileViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(imageId: Int) {
                itemView.findViewById<CircleImageView>(R.id.search_img_profile).setImageResource(imageId)
            }
        }


    }
}