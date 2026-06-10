# Campsite Commander

**Student Number:** ST10539394
**Full Name:** Gcina Mvumvu

## About
Campsite Commander is an Android app built in Kotlin using Android Studio.
It allows users to manage camping gear and food supplies for outdoor adventures.

## Features
- Splash Screen with logo and 3 second delay
- Main Screen with Add Gear button and Total Items Packed counter
- Add Gear dialog with Name, Category, Quantity and Comments inputs
- Input validation with error messages
- Detailed gear list view showing all items
- Back to Base navigation button
- Dark nature-themed UI with forest green colours

## Screens
- SplashActivity - displays logo for 3 seconds then navigates to MainActivity
- MainActivity - main hub using parallel arrays and a loop to count items
- DetailActivity - displays full gear checklist

## Data Storage
Uses parallel arrays to store:
- Item names
- Categories
- Quantities
- Comments

## How the Loop Works
A for loop goes through the quantities array and adds them up to show Total Items Packed.

## Error Handling
- Empty item name shows error message
- Empty quantity shows error message
- Invalid quantity shows error message 
