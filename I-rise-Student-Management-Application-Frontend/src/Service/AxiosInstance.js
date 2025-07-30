import axios from "axios";
// import { jwtDecode } from "jwt-decode"; 
//import { createBrowserHistory } from "history"; 


const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // ✅ Change as per your backend
  headers: {
    'Content-Type': 'application/json',
  },
  // Add other configs if needed
  // timeout: 10000,
  // withCredentials: true,
});


//const history = createBrowserHistory();

// Check if the token is valid
// const isTokenValid = (token) => {
//     try {
//         const decodedToken = jwtDecode(token);
//         const currentTime = Date.now() / 1000; // Convert to seconds
//         return decodedToken.exp && decodedToken.exp > currentTime;
//     } catch (error) {
//         console.error("Invalid token:", error.message);
//         return false;
//     }
// };

// Intercept request to add Authorization header if token exists
// axiosInstance.interceptors.request.use(
//     (config) => {
//         const token = localStorage.getItem("token");

//         if (token && isTokenValid(token)) {
//             config.headers["Authorization"] = `Bearer ${token}`;
//         }

//         return config;
//     },
//     (error) => Promise.reject(error)
// );

// Intercept response to handle authentication issues
// axiosInstance.interceptors.response.use(
//     (response) => response,
//     (error) => {
//         if (error.response && error.response.status === 401) {
//             const token = localStorage.getItem("token");

//             // If the token exists but is invalid/expired, remove it and redirect to login
//             if (token && !isTokenValid(token)) {
//                 localStorage.removeItem("token");
//                 localStorage.removeItem("userRole");
//                 localStorage.removeItem("email");
//                 history.push("/login"); 
//                 window.location.reload(); 
//             }
//         }

//         return Promise.reject(error);
//     }
// );

export default axiosInstance;