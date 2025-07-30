import React from 'react'
import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './DashboardPage/HomePage'
import LoginPage from './DashboardPage/LoginPage'
function App() {
 

  return (
    <>
  
 
        <Router>
     
      <Routes>
        <Route path="/loginpage" element={<LoginPage />} />
         <Route path="/" element={<HomePage />} />
      </Routes>
    </Router>
      
    </>
  )
}

export default App
