import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import BookList from './pages/BookList';
import BorrowReturn from './pages/BorrowReturn';
import Fines from './pages/Fines';
import Reports from './pages/Reports';

function PrivateRoute({children}){
  const token = localStorage.getItem('token');
  return token ? children : <Navigate to='/' />;
}

export default function App(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>} />
        <Route path='/register' element={<Register/>} />
        <Route path='/dashboard' element={<PrivateRoute><Dashboard/></PrivateRoute>} />
        <Route path='/books' element={<PrivateRoute><BookList/></PrivateRoute>} />
        <Route path='/borrow' element={<PrivateRoute><BorrowReturn/></PrivateRoute>} />
        <Route path='/fines' element={<PrivateRoute><Fines/></PrivateRoute>} />
        <Route path='/reports' element={<PrivateRoute><Reports/></PrivateRoute>} />
      </Routes>
    </BrowserRouter>
  );
}
