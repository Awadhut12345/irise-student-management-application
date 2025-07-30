import React, {useState}from "react";
import LoginPage from "./LoginPage";
const NavBar =()=>{

   const [isOpen, setIsOpen] = useState(false);

  return(
     
  

     <nav className=" max-w-7xl bg-blue-600 text-white shadow-md">
      <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
        {/* Logo */}
        <div className="text-2xl font-bold">I-Rise</div>

        {/* Desktop Menu */}
        <ul className="hidden md:flex space-x-6">
          <li><a href="/" className="hover:text-gray-300">Home</a></li>
           <li><a href="#" className="hover:text-gray-300">Contact</a></li>
          <li><a href="#" className="hover:text-gray-300">Trending Courses</a></li>
          <li><a href="#" className="hover:text-gray-300">Courses</a></li>
          <li><a href="#" className="hover:text-gray-300">Free Demo</a></li>
          <li><a href="#" className="hover:text-gray-300">Services</a></li>
          <li><a href="/loginpage" className="hover:text-gray-300">Login</a></li>
          
        </ul>

        {/* Hamburger Icon */}
        <button
          className="md:hidden focus:outline-none"
          onClick={() => setIsOpen(!isOpen)}
        >
          <svg
            className="w-6 h-6"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            {isOpen ? (
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M6 18L18 6M6 6l12 12"
              />
            ) : (
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M4 6h16M4 12h16M4 18h16"
              />
            )}
          </svg>
        </button>
      </div>

      {/* Mobile Menu */}
      {isOpen && (
        <div className="md:hidden px-4 pb-4">
          <ul className="space-y-2">
             <li><a href="/" className="hover:text-gray-300">Home</a></li>
           <li><a href="#" className="hover:text-gray-300">Contact</a></li>
          <li><a href="#" className="hover:text-gray-300">Trending Courses</a></li>
          <li><a href="#" className="hover:text-gray-300">Courses</a></li>
          <li><a href="#" className="hover:text-gray-300">Free Demo</a></li>
          <li><a href="#" className="hover:text-gray-300">Services</a></li>
          <li><a href="/loginpage" className="hover:text-gray-300">Login</a></li>
          </ul>
        </div>
      )}
    </nav>
 

  )
}

export default NavBar;