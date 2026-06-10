# Pseudocode - Campsite Commander
# Student Number: ST10539394
# Full Name: Gcina Mvumvu

## SplashActivity
- Display logo and title
- Wait 3000 milliseconds
- Navigate to MainActivity
- Close SplashActivity

## MainActivity - Parallel Arrays
- itemNames = ["Tent", "Marshmallows", "Flashlight"]
- itemCategories = ["Shelter", "Food", "Safety"]
- itemQuantities = [1, 3, 2]
- itemComments = ["4-person waterproof", "For Smores", "Check batteries"]

## Calculate Total Items (Loop)
- SET total = 0
- FOR EACH qty IN itemQuantities
    - total = total + qty
- RETURN total

## Add Gear
- GET name, category, quantity, comments from user
- IF name is empty THEN show error
- IF quantity is empty THEN show error
- IF quantity is not a number THEN show error
- ELSE add to all four parallel arrays
- UPDATE total display

## DetailActivity
- RECEIVE arrays from MainActivity
- FOR each item in arrays
    - Display name, category, quantity, comments
- Back to Base button returns to MainActivity 
