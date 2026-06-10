// Student Number: ST10539394
// Full Name: Gcina Mvumvu

package com.example.campsitecommander

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val itemNames      = mutableListOf("Tent", "Marshmallows", "Flashlight")
    private val itemCategories = mutableListOf("Shelter", "Food", "Safety")
    private val itemQuantities = mutableListOf(1, 3, 2)
    private val itemComments   = mutableListOf(
        "4-person waterproof",
        "For Smores Mega size",
        "Check batteries AA"
    )

    private lateinit var tvTotalItems: TextView
    private lateinit var btnAddGear: Button
    private lateinit var btnViewList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity created")

        tvTotalItems = findViewById(R.id.tvTotalItems)
        btnAddGear   = findViewById(R.id.btnAddGear)
        btnViewList  = findViewById(R.id.btnViewList)

        updateTotalDisplay()

        btnAddGear.setOnClickListener {
            Log.d(TAG, "Add Gear button clicked")
            showAddGearDialog()
        }

        btnViewList.setOnClickListener {
            Log.d(TAG, "View Gear List button clicked")
            navigateToDetailView()
        }
    }

    private fun calculateTotalItems(): Int {
        var total = 0
        for (qty in itemQuantities) {
            total += qty
        }
        Log.d(TAG, "Total items calculated: $total")
        return total
    }

    private fun updateTotalDisplay() {
        val total = calculateTotalItems()
        tvTotalItems.text = "Total Items Packed: $total"
    }

    private fun showAddGearDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_gear, null)
        val etName     = dialogView.findViewById<EditText>(R.id.etItemName)
        val spinnerCat = dialogView.findViewById<Spinner>(R.id.spinnerCategory)
        val etQty      = dialogView.findViewById<EditText>(R.id.etQuantity)
        val etComments = dialogView.findViewById<EditText>(R.id.etComments)

        val categories = arrayOf("Shelter", "Food", "Safety", "First Aid", "Cooking", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCat.adapter = adapter

        AlertDialog.Builder(this)
            .setTitle("Add Gear Item")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name     = etName.text.toString().trim()
                val category = spinnerCat.selectedItem.toString()
                val qtyStr   = etQty.text.toString().trim()
                val comments = etComments.text.toString().trim()

                when {
                    name.isEmpty() -> {
                        Toast.makeText(this, "Please enter an item name.", Toast.LENGTH_SHORT).show()
                        Log.w(TAG, "Add gear failed: empty name")
                    }
                    qtyStr.isEmpty() -> {
                        Toast.makeText(this, "Please enter a quantity.", Toast.LENGTH_SHORT).show()
                        Log.w(TAG, "Add gear failed: empty quantity")
                    }
                    qtyStr.toIntOrNull() == null || qtyStr.toInt() <= 0 -> {
                        Toast.makeText(this, "Quantity must be a positive number.", Toast.LENGTH_SHORT).show()
                        Log.w(TAG, "Add gear failed: invalid quantity")
                    }
                    else -> {
                        val qty = qtyStr.toInt()
                        itemNames.add(name)
                        itemCategories.add(category)
                        itemQuantities.add(qty)
                        itemComments.add(comments.ifEmpty { "No comments" })
                        Log.d(TAG, "Item added: $name | $category | qty=$qty")
                        updateTotalDisplay()
                        Toast.makeText(this, "$name added!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun navigateToDetailView() {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putStringArrayListExtra("NAMES",      ArrayList(itemNames))
            putStringArrayListExtra("CATEGORIES", ArrayList(itemCategories))
            putIntegerArrayListExtra("QUANTITIES", ArrayList(itemQuantities))
            putStringArrayListExtra("COMMENTS",   ArrayList(itemComments))
        }
        startActivity(intent)
    }
}
