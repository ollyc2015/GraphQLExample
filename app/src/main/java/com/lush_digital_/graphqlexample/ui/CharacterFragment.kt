package com.lush_digital_.graphqlexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.lush_digital_.graphqlexample.R
import com.lush_digital_.graphqlexample.ui.adapter.MyAdapter
import kotlinx.android.synthetic.main.character_fragment.*


class CharacterFragment : Fragment() {

    private var adapter: MyAdapter? = null


    companion object {
        fun newInstance() =
            CharacterFragment()
    }

    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.character_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        init()
    }

    private fun init() {

        viewModel.getGraphQLRickAndMortyCharacters()

        observeResponse()
        observeErrors()

    }


    private fun observeResponse() {

        viewModel.responseData()?.observe(viewLifecycleOwner, Observer {

            adapter = MyAdapter(it.characters?.results)

            val layoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(context?.applicationContext)

            recyclerView?.layoutManager = layoutManager

            recyclerView?.adapter = adapter
            adapter?.notifyDataSetChanged()


        })
    }

    private fun observeErrors(){

        viewModel.errorResponse()?.observe(viewLifecycleOwner, Observer {

            Snackbar.make(activity!!.findViewById(android.R.id.content),
                it, Snackbar.LENGTH_LONG).show()

        })

    }
}
