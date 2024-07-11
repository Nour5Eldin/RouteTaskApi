<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RouteTaskApi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }
        h1, h2 {
            color: #333;
        }
        pre {
            background: #f4f4f4;
            padding: 10px;
            border: 1px solid #ddd;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>RouteTaskApi</h1>

        <h2>Overview</h2>
        <p>RouteTaskApi is an Android application for creating and displaying a list of products using an API. This project demonstrates the use of modern Android development practices and libraries.</p>

        <h2>Features</h2>
        <ul>
            <li>Fetch products from a remote API</li>
            <li>Display products in a list</li>
            <li>Error handling for network issues</li>
        </ul>

        <h2>Tech Stack</h2>
        <ul>
            <li><strong>Programming Language</strong>: Kotlin</li>
            <li><strong>Architecture</strong>: MVVM (Model-View-ViewModel)</li>
            <li><strong>Libraries</strong>:
                <ul>
                    <li>Retrofit for API calls</li>
                    <li>Glide for image loading</li>
                    <li>LiveData and ViewModel for data binding and lifecycle management</li>
                </ul>
            </li>
        </ul>

        <h2>Setup</h2>
        <ol>
            <li>Clone the repository:
                <pre><code>git clone https://github.com/Nour5Eldin/RouteTaskApi.git</code></pre>
            </li>
            <li>Open the project in Android Studio.</li>
            <li>Sync the project with Gradle files.</li>
            <li>Run the app on an emulator or a physical device.</li>
        </ol>

        <h2>Components</h2>
        <ul>
            <li><strong>Activities</strong>: MainActivity</li>
            <li><strong>Fragments</strong>: ProductListFragment</li>
            <li><strong>ViewModel</strong>: ProductViewModel</li>
            <li><strong>Repository</strong>: ProductRepository</li>
            <li><strong>Network</strong>: ProductApiService</li>
        </ul>

        <h2>Topics Covered</h2>
        <ul>
            <li><strong>Networking</strong>: Using Retrofit for making API requests</li>
            <li><strong>Image Loading</strong>: Using Glide for efficient image loading and caching</li>
            <li><strong>Architecture Components</strong>: ViewModel and LiveData</li>
            <li><strong>Dependency Injection</strong>: Using Dagger/Hilt (if applicable)</li>
            <li><strong>Error Handling</strong>: Handling network errors gracefully</li>
        </ul>

        <h2>Usage</h2>
        <p>Ensure you have a working internet connection. Launch the app and view the list of products fetched from the API.</p>

        <h2>Contributing</h2>
        <ol>
            <li>Fork the repository.</li>
            <li>Create a new branch (<code>git checkout -b feature-branch</code>).</li>
            <li>Make your changes and commit them (<code>git commit -m 'Add new feature'</code>).</li>
            <li>Push to the branch (<code>git push origin feature-branch</code>).</li>
            <li>Open a pull request.</li>
        </ol>

        <h2>License</h2>
        <p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>
    </div>
</body>
</html>
