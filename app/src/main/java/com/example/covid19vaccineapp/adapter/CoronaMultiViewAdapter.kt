package com.example.covid19vaccineapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ItemSymptomsLeftBinding
import com.example.covid19vaccineapp.databinding.ItemSymptomsRightBinding

class CoronaMultiViewAdapter(private val listTitle: List<String>, private val listImage: List<Int>) :
    RecyclerView.Adapter<CoronaMultiViewAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    override fun getItemViewType(position: Int) = if (position % 2 == 0) LAYOUT_LEFT else LAYOUT_RIGHT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        when (viewType) {
            LAYOUT_LEFT -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_symptoms_left, parent, false)
                return SymptomsLeftHolderView(view)
            }
            LAYOUT_RIGHT -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_symptoms_right, parent, false)
                return SymptomsLeftHolderView(view)
            }
        }
        return super.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = listTitle[position]
        val currentImage = listImage[position]
        when(holder){
            is SymptomsLeftHolderView -> {
                holder.binding.apply {
                    txtSymptoms.text = currentItem
                    imgCorona.setImageDrawable(ContextCompat.getDrawable(context, currentImage))
                }
            }
            is SymptomsRightHolderView -> {
                holder.binding.apply {
                    txtSymptoms.text = currentItem
                    imgCorona.setImageDrawable(ContextCompat.getDrawable(context, currentImage))
                }
            }
        }
    }

    override fun getItemCount() = listTitle.size

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //****************  VIEW HOLDER LEFT ******************//

    class SymptomsLeftHolderView(itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemSymptomsLeftBinding.bind(itemView)
    }

    //****************  VIEW HOLDER RIGHT ******************//

    class SymptomsRightHolderView(itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemSymptomsRightBinding.bind(itemView)
    }

    companion object {
        const val LAYOUT_LEFT: Int = 0
        const val LAYOUT_RIGHT: Int = 1
    }

}