# Film Vault

Film Vault is a full-stack web application that allows users to search for films (movies and TV series) and build a personal collection. The project emphasizes clean API design, role-based access control, and a minimalist user interface focused on core functionality.

---

## Tech Stack

### Backend

- Java
- Spring Boot
- Spring Security (JWT authentication)
- PostgreSQL
- OMDb API

### Frontend

- React
- Vite
- Axios
- React Router

---

## Core Concepts

- A **film** is defined as either a movie or a television series.
- The application distinguishes between **unauthenticated** and **authenticated** users.
- Authentication is required only for collection-related features.
- Film data is retrieved from the OMDb API and persisted selectively for user collections.

---

## Current Backend Functionality

### Unauthenticated Users

- Search for a film by title
- Retrieve full film details
- Register a new user account
- Log in to an existing account

### Authenticated Users

- Add a film to their personal collection
- Retrieve their full film collection
- Remove a film from their collection
- Retrieve subsets of their collection filtered by:
  - Film type (movie or series)
  - Genre
  - Rating
  - Release year
  - Director
  - Actor

---

## Frontend Architecture & Goals

> The frontend is actively under development.  
> The sections below describe **current behavior where implemented**, as well as **intended design goals** for the final user experience.

---

## Application Views

### HomeView

**Current**

- Serves as the primary entry point for the application
- Allows users to search for films by title
- Displays search results as FilmCards
- Clicking a FilmCard navigates to the SingleFilmView

**Planned**

- Display search results in a grid layout
- Support multiple results for films with similar titles
- Allow authenticated users to add films to their collection directly from search results

---

### SingleFilmView

**Current**

- Displays detailed information for a selected film

**Film details include:**

- Film type (movie or series)
- Title
- Release year
- Rating
- Release date
- Runtime
- Genre
- Director
- Actors
- Plot
- Language
- Country
- Awards
- Poster
- IMDb rating

**Planned**

- Allow authenticated users to add the film to their collection from this view

---

### CollectionView

**Current**

- Displays all films saved to the authenticated user’s collection

**Planned**

- Display the collection in a grid layout using FilmCards
- Allow users to:
  - Search within their collection
  - Filter films by type, genre, rating, release year, director, or actor
  - Remove films from their collection
- Clicking a FilmCard navigates to the SingleFilmView

---

## Reusable UI Components

### Header

- Displays application branding
- Shows a user greeting when authenticated
- Clicking the title or logo navigates to the HomeView

### NavBar

- Provides navigation between application views
- Contains a global search bar
- Displays login or logout actions depending on authentication state

### Footer

- Simple footer displayed on all pages

---

## Design Philosophy

- Minimalist UI focused on usability and clarity
- Separation of concerns between views and reusable components
- Backend-driven authorization rules
- Frontend designed to evolve incrementally without large refactors

---

## Future Enhancements

- Support for trending or popular films
- Pagination for large result sets
- Improved filtering and sorting UI
- Expanded use of OMDb search endpoints
- Enhanced collection analytics

---

## Why This Project

Film Vault was built to demonstrate:

- Full-stack application design
- Secure authentication and authorization
- RESTful API architecture
- Integration with third-party APIs
- Clean React component structure
