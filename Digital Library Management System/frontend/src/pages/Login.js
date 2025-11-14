import React, {useState} from 'react';
import api from '../api';
import { useNavigate } from 'react-router-dom';

export default function Login(){
  const [email,setEmail]=useState(''); const [password,setPassword]=useState('');
  const nav = useNavigate();
  const submit = async (e)=>{
    e.preventDefault();
    try {
      const res = await api.post('/api/auth/login',{email,password});
      localStorage.setItem('token', res.data.token);
      localStorage.setItem('role', res.data.role);
      localStorage.setItem('userId', res.data.userId);
      nav('/dashboard');
    } catch(err){ alert('Login failed'); console.error(err); }
  };
  return (
    <div style={{maxWidth:420, margin:'40px auto'}}>
      <h2>DLMS Login</h2>
      <form onSubmit={submit}>
        <div><label>Email</label><input value={email} onChange={e=>setEmail(e.target.value)} required/></div>
        <div><label>Password</label><input type='password' value={password} onChange={e=>setPassword(e.target.value)} required/></div>
        <button type='submit'>Login</button>
      </form>
      <p>New? <a href="/register">Register</a></p>
    </div>
  );
}
