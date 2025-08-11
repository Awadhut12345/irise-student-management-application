import React from 'react'
import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './DashboardPage/HomePage'
import LoginPage from './DashboardPage/LoginPage'
import { AdminDashboard } from './Component/Admin/AdminDashboard';
import AdminRegister from './Component/AdminPage/AdminRegister';
function App() {
 

  return (
    <>
  
 
        <Router>
     
      <Routes>
        <Route path="/AdminDashboard" element={<AdminDashboard/>} />
        <Route path="/loginpage" element={<LoginPage />} />
        <Route path="/adminRegister" element={<AdminRegister/>}/>
         <Route path="/" element={<HomePage />} />
      </Routes>
    </Router>
      
    </>
  )
}

export default App
