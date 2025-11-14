import React, {useState} from 'react';
import api from '../api';
import { useNavigate } from 'react-router-dom';

export default function Register(){
  const [name,setName]=useState(''); const [email,setEmail]=useState(''); const [password,setPassword]=useState('');
  const [role,setRole]=useState('MEMBER');
  const nav = useNavigate();
  const submit = async (e)=>{ e.preventDefault(); try{ await api.post('/api/auth/register',{name,email,password,role}); alert('Registered'); nav('/'); }catch(e){alert('Error');} };
  return (
    <div style={{maxWidth:520, margin:'40px auto'}}>
      <h2>Register</h2>
      <form onSubmit={submit}>
        <div><label>Name</label><input value={name} onChange={e=>setName(e.target.value)} required/></div>
        <div><label>Email</label><input value={email} onChange={e=>setEmail(e.target.value)} required/></div>
        <div><label>Password</label><input type='password' value={password} onChange={e=>setPassword(e.target.value)} required/></div>
        <div><label>Role</label><select value={role} onChange={e=>setRole(e.target.value)}><option>MEMBER</option><option>LIBRARIAN</option><option>ADMIN</option></select></div>
        <button type='submit'>Register</button>
      </form>
    </div>
  );
}
