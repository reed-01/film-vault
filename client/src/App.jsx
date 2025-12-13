import { BrowserRouter, Routes, Route } from "react-router-dom";

import Header from "./components/Header/Header";
import NavBar from "./components/NavBar/NavBar";
import Footer from "./components/Footer/Footer";
import LoginView from "./views/LoginView/LoginView";
import LogoutView from "./views/LogoutView";
import RegisterView from "./views/RegisterView/RegisterView";

import HomeView from "./views/HomeView/HomeView";
import SingleFilmView from "./views/SingleFilmView/SingleFilmView";
import ProtectedRoute from "./components/ProtectedRoute";

export default function App() {
  return (
      <BrowserRouter>
        <div id="film-app">
          <Header />
          <NavBar />

          <main>
            <Routes>
              <Route path="/" element={<HomeView />} />
              <Route path="/film/id" element={<SingleFilmView />} />
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
        </div>
      </BrowserRouter>
  );
}
