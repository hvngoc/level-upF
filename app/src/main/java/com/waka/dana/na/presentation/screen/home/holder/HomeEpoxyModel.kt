package com.waka.dana.na.presentation.screen.home.holder

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.waka.dana.na.R
import com.waka.dana.na.databinding.ItemHomeBinding

/**
 * Created by hvngoc on 7/29/22
 */

@EpoxyModelClass(layout = R.layout.item_home)
abstract class HomeEpoxyModel :
    EpoxyModelWithHolder<HomeEpoxyModel.ChildHolder>() {

    @EpoxyAttribute
    var name: String? = null

    @EpoxyAttribute
    var id: String? = null

    @EpoxyAttribute
    var numF1: Int? = 0

    @EpoxyAttribute
    var price: Int? = 0

    @EpoxyAttribute
    var numSell: Int? = null

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var onActionClick: (() -> Unit)? = null


    override fun bind(holder: ChildHolder) {
        val context = holder.binding.root.context

        holder.binding.name.text = name
        holder.binding.userId.text = id
        holder.binding.numF1.text = context.getString(R.string.num_f1, numF1?.toString())
        holder.binding.price.text = context.getString(R.string.price, price?.toString())
        holder.binding.numSell.text = context.getString(R.string.num_sell, numSell?.toString())

        holder.binding.root.setOnClickListener { onActionClick?.invoke() }
    }

    class ChildHolder : EpoxyHolder() {

        lateinit var binding: ItemHomeBinding

        override fun bindView(itemView: View) {
            binding = ItemHomeBinding.bind(itemView)
        }
    }
}