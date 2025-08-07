import React from 'react'
import './App.css'
<<<<<<< HEAD
import AdminDashboard from './Component/Admin/AdminDashboard'
import LoginPage from './DashboardPage/LoginPage'

=======
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './DashboardPage/HomePage'
import LoginPage from './DashboardPage/LoginPage'
import { AdminDashboard } from './Component/Admin/AdminDashboard';
>>>>>>> main
function App() {
 

  return (
    <>
<<<<<<< HEAD
        <AdminDashboard/>

      <LoginPage/>
=======
  
 
        <Router>
     
      <Routes>
        <Route path="/AdminDashboard" element={<AdminDashboard/>} />
        <Route path="/loginpage" element={<LoginPage />} />
         <Route path="/" element={<HomePage />} />
      </Routes>
    </Router>
      
>>>>>>> main
    </>
  )
}

export default App
