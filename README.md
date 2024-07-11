# RouteTaskApi

## Overview
RouteTaskApi is an Android application for creating and displaying a list of products using an API. This project demonstrates the use of modern Android development practices and libraries.

## Features
- Fetch products from a remote API
- Display products in a list
- SearchView products in the list
- Error handling for network issues

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

## Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/Nour5Eldin/RouteTaskApi.git
