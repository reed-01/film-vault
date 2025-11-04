import { BrowserRouter, Routes, Route } from "react-router-dom";

import Header from "./components/Header/Header";
import NavBar from "./components/NavBar/NavBar";
import Footer from "./components/Footer/Footer";
import LoginView from "./views/LoginView/LoginView";
import LogoutView from "./views/LogoutView";
import RegisterView from "./views/RegisterView/RegisterView";

import HomeView from "./views/HomeView/HomeView";
import SingleMovieView from "./views/SingleMovieView/SingleMovieView";
import ProtectedRoute from "./components/ProtectedRoute";

export default function App() {
  return (
    <div id="film-app">
      <BrowserRouter>
        <Header />
        <NavBar />

        <main>
          <Routes>
            <Route path="/" element={<HomeView />} />
            <Route path="/movies/id" element={<SingleMovieView />} />
            <Route
              path="/collection"
              element={
                <ProtectedRoute>
                  <CollectionView />
                </ProtectedRoute>
              }
            />
            <Route path="/login" element={<LoginView />} />
            <Route path="/logout" element={<LogoutView />} />
            <Route path="/register" element={<RegisterView />} />
          </Routes>
        </main>

        <Footer />
      </BrowserRouter>
    </div>
  );
}
