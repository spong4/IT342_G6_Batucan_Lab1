import React, { useState } from 'react';
import API from '../api';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [credentials, setCredentials] = useState({ email: '', password: '' });
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const res = await API.post('/auth/login', credentials);
            localStorage.setItem('token', res.data.token);
            navigate('/dashboard');
        } catch (err) {
            alert("Invalid email or password.");
        }
    };

    return (
        <div style={{ maxWidth: '400px', margin: '100px auto' }}>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <input type="email" placeholder="Email" onChange={e => setCredentials({...credentials, email: e.target.value})} required /><br/>
                <input type="password" placeholder="Password" onChange={e => setCredentials({...credentials, password: e.target.value})} required /><br/>
                <button type="submit">Login</button>
            </form>
            <p>New user? <a href="/register">Register here</a></p>
        </div>
    );
};

export default Login;