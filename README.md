# RouteTaskApi

## Overview
RouteTaskApi is an Android application for creating and displaying a list of products using an API. This project demonstrates the use of modern Android development practices and libraries.

## Screen Shot

<img width="360" alt="Screenshot 2024-07-11 at 2 32 58 PM" src="https://github.com/Nour5Eldin/RouteTaskApi/assets/145837378/95b258e5-109e-457d-b023-af1b352694b0">
<img width="360" alt="Screenshot 2024-07-13 at 1 07 30 PM" src="https://github.com/user-attachments/assets/2169a96e-d6d2-4120-9d98-d9a36f6834fd">



## Features
- Fetch products from a remote API
- Display products in a list
- SearchView products in the list
- Error handling for network issues
- Adding the favorites button it change when interact
- Adding the add button increases the number of product orders

## Tech Stack
- **Programming Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Libraries**:
  - Retrofit for API calls
  - Glide for image loading
  - LiveData and ViewModel for data binding and lifecycle management
  - 
## Components
- Activities: MainActivity
- ViewModel: ProductViewModel
- Repository: (ProductRepository , ProductRepositoryImpl)
- Network: (ApiService , NetworkModule)
  
## Topic Covered
- Networking: Using Retrofit for making API requests
- Image Loading: Using Glide for efficient image loading and caching
- Architecture Components: ViewModel and LiveData
- Dependency Injection: Using Dagger/Hilt (if applicable)
- Error Handling: Handling network errors gracefully
- SharedPreferences : Saving item product wishlist event as a Favourite product

## Setup
1. Clone the repository:
   ```sh
    https://github.com/Nour5Eldin/RouteTaskApi.git

## License
- This project is licensed under the MIT License. See the LICENSE file for details.


