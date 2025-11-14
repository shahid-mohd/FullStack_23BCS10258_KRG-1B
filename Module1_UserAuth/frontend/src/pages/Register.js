import React, {useState} from 'react';
import axios from 'axios';
export default function Register(){
  const [name,setName]=useState(''); const [email,setEmail]=useState(''); const [password,setPassword]=useState('');
  const [role,setRole]=useState('MEMBER');
  const submit=async(e)=>{ e.preventDefault(); try{ await axios.post('/api/auth/register',{name,email,password,role}); alert('Registered'); }catch(e){ alert('Error'); } };
  return (<div style={{padding:20}}><h3>Register</h3><form onSubmit={submit}><input value={name} onChange={e=>setName(e.target.value)} placeholder='name'/><br/><input value={email} onChange={e=>setEmail(e.target.value)} placeholder='email'/><br/><input value={password} onChange={e=>setPassword(e.target.value)} placeholder='password'/><br/><select value={role} onChange={e=>setRole(e.target.value)}><option>MEMBER</option><option>LIBRARIAN</option><option>ADMIN</option></select><br/><button>Register</button></form></div>);
}
