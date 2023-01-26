package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Adapter(private val context: Context, private val quotesList: ArrayList<Quotes>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val quotes = LayoutInflater.from(context).inflate(R.layout.rvitem, parent, false)
        return Adapter.ViewHolder(quotes)
//        viewModel = ViewModelProvider(ViewModelStoreOwner(::ViewModelStore))[MainViewModel::class.java]


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.data.collect { data ->
                holder.Id.text = data[position].id.toString()
                holder.Quote.text = data[position].quote.toString()
                holder.Author.text = data[position].author.toString()

            }
        }

    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Id: TextView
        var Quote: TextView
        var Author: TextView

        init {
            Id = itemView.findViewById(R.id.tvId)
            Quote = itemView.findViewById(R.id.tvQuote)
            Author = itemView.findViewById(R.id.tvAuthor)
        }
    }
}
