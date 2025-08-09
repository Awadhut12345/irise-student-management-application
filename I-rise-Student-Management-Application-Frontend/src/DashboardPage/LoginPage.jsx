import React, {  useState } from "react";
import NavBar from "./NavBar";
import axios from "axios";

import { Navigate } from "react-router-dom";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (e) => {
  e.preventDefault();
  
  console.log("Logging in with:", email, password);
  const navigate = Navigate()

 axios
    .post("http://localhost:8080/admin/v1/loginAdmin", {email, password })
    .then((response) => {
      console.log("Login Success:", response.data);

       if(response.status === 200){

        navigate('/home')

        console.log("succssfull");}
    })
    .catch((error) => {
      console.error("Login Failed:", error);
    });

   

};


  return (
    <>
      <NavBar />
      <div className="min-h-screen flex items-center justify-center bg-gray-100">
        <form
          onSubmit={handleLogin}
          className="bg-white p-6 rounded-lg shadow-lg w-full max-w-sm"
        >
          <h2 className="text-2xl font-semibold mb-6 text-center">Login</h2>
          <div className="mb-4">
            <label className="block text-gray-700">Role</label>
            <div className="">
                <select name="role" id="role">
              <option value="admin">Admin</option>
              <option value="staff">Staff</option>
              <option value="student">Student</option>
            </select>
            </div>
         
            <label className="block text-gray-700">Email</label>
            <input
              type="email"
              className="w-full p-2 border border-gray-300 rounded mt-1"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="mb-6">
            <label className="block text-gray-700">Password</label>
            <input
              type="password"
              className="w-full p-2 border border-gray-300 rounded mt-1"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button
            type="submit"
            className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition duration-200"
          >
            Login
          </button>

        <h1>register </h1>
        </form>


      </div>
    </>
  );
};

export default LoginPage;
