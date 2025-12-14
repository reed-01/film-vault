import { BrowserRouter, Routes, Route } from "react-router-dom";

import Header from "./components/Header/Header";
import NavBar from "./components/NavBar/NavBar";
import Footer from "./components/Footer/Footer";
import ProtectedRoute from "./components/ProtectedRoute";

import HomeView from "./views/HomeView/HomeView";
import LoginView from "./views/LoginView/LoginView";
import LogoutView from "./views/LogoutView";
import RegisterView from "./views/RegisterView/RegisterView";
import SingleFilmView from "./views/SingleFilmView/SingleFilmView";
import CollectionView from "./views/CollectionView/CollectionView";

export default function App() {

  return (
    <BrowserRouter>
      <div id="app">
        
        <Header />
        <NavBar />

        <main id="main-content">
          <Routes>
            <Route path="/" element={<HomeView />} />
            <Route path="/login" element={<LoginView />} />
            <Route path="/logout" element={<LogoutView />} />
            <Route path="/register" element={<RegisterView />} />
            <Route path="/film/:id" element={<SingleFilmView/> } />

            <Route
              path="/collection/:userId"
              element={
                <ProtectedRoute>
                  <CollectionView />
                </ProtectedRoute>
              }
            />
          </Routes>
        </main>

        <Footer />

      </div>
    </BrowserRouter>
  );
}