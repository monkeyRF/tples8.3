package com.bignerdranch.android.tples83

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonsAdapter(
    private val deleteAction: (Int) -> Unit,
    private val likeAction: (Int) -> Unit,
    private val renameAction: (Int) -> Unit
): RecyclerView.Adapter<PersonsAdapter.PersonViewHolder>() {

    private val persons = mutableListOf<Person>()
    //private val diffUtilCallback = PersonsDiffUtilCallback()

    class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photo)
        val fullnameTextView: TextView = itemView.findViewById(R.id.fullname)
        val deleteButton: ImageView = itemView.findViewById(R.id.delete)
        val likeButton: ImageView = itemView.findViewById(R.id.like)
        val editButton: ImageView = itemView.findViewById(R.id.edit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_list_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]
        with(holder){
            fullnameTextView.text = person.fullName

            Glide.with(photoImageView.context)
                .load(person.photoUrl)
                .centerCrop()
                .into(photoImageView)

            deleteButton.setOnClickListener{
                deleteAction(position)
            }

            if (person.like) likeButton.setImageResource(R.drawable.ic_favorite)
            else likeButton.setImageResource(R.drawable.ic_unfavorite)

            likeButton.setOnClickListener{
                likeAction(position)
            }

            editButton.setOnClickListener {
                renameAction(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    fun reload(data: List<Person>) {

        val diffCallback = PersonsDiffUtilCallback(persons, data)
        val personsDiffResult = DiffUtil.calculateDiff(diffCallback)

        persons.clear()
        persons.addAll(data)
        //personsDiffResult.dispatchUpdatesTo(this)

        notifyDataSetChanged()
    }
}