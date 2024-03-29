package com.levandowski.adapter.chat

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.levandowski.R
import com.levandowski.model.Message

//TODO pendente
class ChatAdapter(ref: FirestoreRecyclerOptions<Message>) : FirestoreRecyclerAdapter<Message, ChatHolder>(ref) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder =
        ChatHolder(when (viewType) {
            SEND -> LayoutInflater.from(parent.context).inflate(R.layout.chat_send, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.chat_receive, parent, false)
        })

    override fun onBindViewHolder(holder: ChatHolder, position: Int, model: Message) {
        when (getItemViewType(position)) {
            SEND -> {
                holder.Send().run {
                    messageText.text = model.messageText
//                    messageUser.text = model.user.name
                    messageTime.text = DateFormat.format("HH:mm", model.messageTime.toString().toLong())
                }
            }
            else -> {
                holder.Received().run {
                    messageText.text = model.messageText
//                    messageUser.text = model.user.name
                    messageTime.text = DateFormat.format("HH:mm", model.messageTime.toString().toLong())
                }
            }
        }
    }

//    override fun getItemViewType(position: Int): Int =
//        if (getItem(position).user.email == "gustavolevandowski@gmail.com") SEND else RECEIVE

    companion object {
        const val SEND = 0
        const val RECEIVE = 1
    }
}