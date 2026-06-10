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

##Screenshot
<img width="1920" height="1080" alt="Screenshot 2026-06-10 142549" src="https://github.com/user-attachments/assets/80f4bb85-992e-4eaa-8695-68507b3e2129" />
<img width="1920" height="1080" alt="Screenshot 2026-06-10 142536" src="https://github.com/user-attachments/assets/83b86071-4201-47e6-997c-5c6ce27e266f" />
<img width="1920" height="1080" alt="Screenshot 2026-06-10 142517" src="https://github.com/user-attachments/assets/b3e47eba-b1c8-43af-bcc5-84046fe8e361" />

## How the Loop Works
A for loop goes through the quantities array and adds them up to show Total Items Packed.

## Error Handling
- Empty item name shows error message
- Empty quantity shows error message
- Invalid quantity shows error message

## Write-Up: Proof of Functionality

### SplashActivity
- App opens and displays the Campsite Commander
  logo and title for 3 seconds
- Automatically navigates to MainActivity after
  3000ms using a Handler

### MainActivity
- Displays total items packed calculated using
  a FOR loop through the itemQuantities array
- Pre-loaded with 3 sample items (Tent,
  Marshmallows, Flashlight) with total of 6
- Add Gear button opens a dialog with input fields
- Error handling shows Toast messages when:
  - Item name is empty
  - Quantity is empty
  - Quantity is not a valid number

### DetailActivity
- Displays full gear list using a FOR loop
  through all parallel arrays
- Shows Item name, Category, Quantity and Comments
- Back to Base button returns to MainActivity

### Data Storage
- Uses 4 parallel arrays to store item data
- itemNames, itemCategories, itemQuantities
  and itemComments all linked by index

### Build Status
- Project builds successfully in Android Studio
- BUILD SUCCESSFUL in 2m 28s confirmed 


