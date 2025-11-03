import { createRoot } from "react-dom/client";
import axios from "axios";

import App from "./App.jsx";
import UserProvider from "./context/UserProvider.jsx";

/* import fontawesome core */
import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faCartPlus,
  faMagnifyingGlass,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";

/* add icons to the library */
library.add(faCartPlus);
library.add(faMagnifyingGlass);
library.add(faTrashCan);

// Set base url for server API communication with axios
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

createRoot(document.getElementById("root")).render(
  <UserProvider>
    <App />
  </UserProvider>
);
