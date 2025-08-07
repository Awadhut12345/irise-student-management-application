"use client"

import { useState } from "react"

// Since you might not have shadcn/ui components, I'll create the dashboard using pure Tailwind CSS
export function AdminDashboard() {
  const [activeItem, setActiveItem] = useState("Dashboard")
  const [sidebarOpen, setSidebarOpen] = useState(true)
  const [profileDropdownOpen, setProfileDropdownOpen] = useState(false)

  const menuItems = [
    { title: "Dashboard", icon: "🏠" },
    
  ]

  const handleMenuClick = (itemTitle) => {
    setActiveItem(itemTitle)
  }

  const toggleSidebar = () => {
    setSidebarOpen(!sidebarOpen)
  }

  const toggleProfileDropdown = () => {
    setProfileDropdownOpen(!profileDropdownOpen)
  }

  return (
    <div className="flex min-h-screen bg-gray-100">
      {/* Sidebar */}
      <div className={`${sidebarOpen ? "w-64" : "w-16"} bg-white shadow-lg transition-all duration-300 ease-in-out`}>
        {/* Sidebar Header */}
        <div className="p-4 border-b border-gray-200">
          <div className="flex items-center space-x-3">
            <div className="w-8 h-8 bg-blue-600 rounded-lg flex items-center justify-center">
              <span className="text-white font-bold text-sm">📦</span>
            </div>
            {sidebarOpen && (
              <div>
                <h2 className="text-lg font-semibold text-gray-800">Admin Panel</h2>
                <p className="text-xs text-gray-500">Enterprise</p>
              </div>
            )}
          </div>
        </div>

        {/* Navigation Menu */}
        <nav className="mt-4">
          <div className="px-4 mb-2">
            {sidebarOpen && <h3 className="text-xs font-semibold text-gray-400 uppercase tracking-wider">Main Menu</h3>}
          </div>
          <ul className="space-y-1 px-2">
            {menuItems.map((item) => (
              <li key={item.title}>
                <button
                  onClick={() => handleMenuClick(item.title)}
                  className={`w-full flex items-center px-3 py-2 rounded-lg text-left transition-colors duration-200 ${
                    activeItem === item.title
                      ? "bg-blue-100 text-blue-700 border-r-2 border-blue-700"
                      : "text-gray-600 hover:bg-gray-100 hover:text-gray-900"
                  }`}
                >
                  <span className="text-lg mr-3">{item.icon}</span>
                  {sidebarOpen && <span className="font-medium">{item.title}</span>}
                </button>
              </li>
            ))}
          </ul>

          {/* Settings Section */}
          <div className="px-4 mt-6 mb-2">
            {sidebarOpen && <h3 className="text-xs font-semibold text-gray-400 uppercase tracking-wider">System</h3>}
          </div>
          <ul className="space-y-1 px-2">
            <li>
              <button
                onClick={() => handleMenuClick("Settings")}
                className={`w-full flex items-center px-3 py-2 rounded-lg text-left transition-colors duration-200 ${
                  activeItem === "Settings"
                    ? "bg-blue-100 text-blue-700 border-r-2 border-blue-700"
                    : "text-gray-600 hover:bg-gray-100 hover:text-gray-900"
                }`}
              >
                <span className="text-lg mr-3">⚙️</span>
                {sidebarOpen && <span className="font-medium">Settings</span>}
              </button>
            </li>
          </ul>
        </nav>

        {/* Sidebar Footer - User Profile */}
        {sidebarOpen && (
          <div className="absolute bottom-0 w-64 p-4 border-t border-gray-200 bg-white">
            <div className="flex items-center space-x-3">
              <div className="w-8 h-8 bg-gray-300 rounded-full flex items-center justify-center">
                <span className="text-gray-600 font-semibold text-sm">AD</span>
              </div>
              <div className="flex-1">
                <p className="text-sm font-medium text-gray-800">Admin User</p>
                <p className="text-xs text-gray-500">admin@company.com</p>
              </div>
            </div>
          </div>
        )}
      </div>

      {/* Main Content */}
      <div className="flex-1 flex flex-col">
        {/* Header */}
        <header className="bg-white shadow-sm border-b border-gray-200 px-6 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center space-x-4">
              {/* Sidebar Toggle */}
              <button
                onClick={toggleSidebar}
                className="p-2 rounded-lg hover:bg-gray-100 transition-colors duration-200"
              >
                <span className="text-gray-600">☰</span>
              </button>

              {/* Profile Icon in Top Left */}
              <div className="relative">
                <button
                  onClick={toggleProfileDropdown}
                  className="flex items-center space-x-2 p-2 rounded-full hover:bg-gray-100 transition-colors duration-200"
                >
                  <div className="w-8 h-8 bg-blue-500 rounded-full flex items-center justify-center">
                    <span className="text-white font-semibold text-sm">JD</span>
                  </div>
                </button>

                {/* Profile Dropdown */}
                {profileDropdownOpen && (
                  <div className="absolute top-12 left-0 w-56 bg-white rounded-lg shadow-lg border border-gray-200 py-2 z-50">
                    <div className="px-4 py-2 border-b border-gray-100">
                      <p className="text-sm font-medium text-gray-800">John Doe</p>
                      <p className="text-xs text-gray-500">john.doe@example.com</p>
                    </div>
                    <a href="#" className="flex items-center px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">
                      <span className="mr-2">👤</span>
                      Profile
                    </a>
                   
                  </div>
                )}
              </div>
            </div>

            {/* Header Right Side */}
            <div className="flex items-center space-x-4">
              <button className="p-2 rounded-lg hover:bg-gray-100 transition-colors duration-200">
                <span className="text-gray-600">🔍</span>
              </button>
              <button className="p-2 rounded-lg hover:bg-gray-100 transition-colors duration-200 relative">
                <span className="text-gray-600">🔔</span>
                <span className="absolute -top-1 -right-1 w-3 h-3 bg-red-500 rounded-full"></span>
              </button>
            </div>
          </div>
        </header>

        {/* Dashboard Content */}
        <main className="flex-1 p-6">
         
        </main>
      </div>
    </div>
  )
}

export default AdminDashboard
