# TestApp

This project simulate the fetching of books from a remote source but without an API.

The source of data are two different sources cache (json hardcoded data) and database (the books that the user insert in the app)

## Architecture

This project follows the Clean Architecture pattern, separating it into three distinct layers: **UI**, **Domain**, and **Data**.

### UI Layer

In the UI layer, we adopt the MVI (Model-View-Intent) architecture with Effects, ViewStates, and ViewActions.

- **Effects**: Responsible for displaying toasts or navigating to other screens.

- **ViewStates**: Represent the current state of the application in a unidirectional data flow.

- **ViewActions**: Define user input actions for refreshing data.

### Data Layer

The repository acts as an intermediary between three data sources:

- **Database Source**: Manages books that users insert into the application.

- **Cache Source**: Contains hardcoded JSON data used for local storage.

- **Remote Source**: Simulates fetching data from a remote API. To simulate backend unavailability, local feature flags are used, which should only be enabled for debugging purposes.

## Key Features

- Multi module project structure (see graphic for module organization).

- UI testing for Composables.

- Unit testing for reactive ViewModels and Repositories.

- Stateless Composables under folder views, to provide a better ui testability and state hoisting 

- Version catalogs for graddle management 

- Design system with few atoms in material 3

## Project Structure

feature module layers, libs and common see the diagram

## Usage

For display the data in debug mode that simulate the local json info is necessary to activate the simulateGetBooksApiIsNotAvailable feature flag

To develop this project I used Android Studio Giraffe | 2022.3.1 Patch 1

