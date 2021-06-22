package com.app.github.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.github.R
import com.app.github.core.base.IBaseClickListener
import com.app.github.databinding.ItemReyclerviewBinding
import com.app.github.presentation.model.GithubModel
import com.app.github.presentation.model.GithubModelItem
import com.app.github.presentation.view.fragment.HomeFragmentDirections

class MainAdapter(private val context: Context) :
    RecyclerView.Adapter<MainAdapter.GithubViewHolder>() {
    private var githubModelList: GithubModel = GithubModel()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubViewHolder {
        val binding: ItemReyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_reyclerview, parent, false
        )
        return GithubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(githubModelList[position])
    }

    fun updateList(resultModelItemList: GithubModel) {
        this.githubModelList = resultModelItemList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = githubModelList.size

    class GithubViewHolder(private val binding: ItemReyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root), IBaseClickListener<GithubModelItem> {

        fun bind(item: GithubModelItem) {
            binding.itemClickListener = this
            binding.model = item
            binding.executePendingBindings()
        }

        override fun onClick(t: GithubModelItem) {
            t.let {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    t
                )
                Navigation.findNavController(binding.root).navigate(action)
            }
        }

    }
}