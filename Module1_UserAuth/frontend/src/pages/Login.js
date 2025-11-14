import React, {useState} from 'react';
import axios from 'axios';
export default function Login(){
  const [email,setEmail]=useState(''); const [password,setPassword]=useState('');
  const submit = async (e)=>{ e.preventDefault(); try{ const res = await axios.post('/api/auth/login',{email,password}); alert('Token: '+res.data.token); }catch(e){ alert('Login failed'); } };
  return (<div style={{padding:20}}><h3>Login</h3><form onSubmit={submit}><input value={email} onChange={e=>setEmail(e.target.value)} placeholder='email'/><br/><input value={password} onChange={e=>setPassword(e.target.value)} placeholder='password'/><br/><button>Login</button></form></div>);
}
