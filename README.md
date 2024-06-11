# Fetch Rewards Coding Exercise - Android App

This is a native Android app written in Kotlin+java that retrieves data from the given URL and displays it in a RecyclerView. 
The app groups items by `listId`, sorts them by `listId` and `name`, and filters out items where `name` is blank or null.

## Requirements
1. **Fetch Data**: Retrieve data from the provided URL.
2. **Group Items**: Group items by `listId`.
3. **Sort Items**: Sort the items first by `listId` and then by `name`.
4. **Filter Items**: Filter out any items where `name` is blank or null.
5. **Display Items**: Display the final list in an easy-to-read format.

## Features
- Fetches data from the provided API endpoint.
- Groups, sorts, and filters the items based on the requirements.
- Displays the items in a RecyclerView.
- Shows an error message if data fetching fails.

## Screenshots / GIFs
![App Demo](https://github.com/dharmikbhanushali/fetch-rewards-takehome-assessment/blob/main/fetch-rewards-solution.gif)

## Code Overview

### Classes and Files Created

- **MainActivity.kt**
  - Initializes views, and handles data fetching and error handling.
  
- **ItemAdapter.java**
  - RecyclerView adapter that binds item data to the views.
  
- **fetchService.java**
  - Defines the API endpoints using Retrofit annotations.
  
- **fetchClient.java**
  - Class to manage the Retrofit instance.

- **Item.java**
  - Model class representing an item with `id`, `listId`, and `name` attributes.

- **activity_main.xml**
  - Layout file for the main activity, including a RecyclerView and a TextView for error messages.

- **item_view.xml**
  - Layout file for individual items in the RecyclerView.

- **themes.xml**
  - Defines the application themes and styles.

## Setup and Installation

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Solution Explanation

- **Data Fetching**: Using Retrofit to make network requests and fetch data from the provided URL.
- **Data Processing**: Filters out items with blank or null names, groups them by `listId`, and sorts them first by `listId` and then by `name`.
- **Error Handling**: Displays an error message if the data fetching fails.

- In the fetchItems function, an alternative approach is used for sorting the items. Instead of sorting the name field lexicographically (as a string), this solution extracts the numeric part from the name (assuming the format "Item X") and sorts the items based on these numeric values. This ensures that the items are sorted numerically rather than alphabetically.
