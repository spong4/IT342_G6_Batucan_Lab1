import React, { useState } from 'react';
import API from '../api';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const [user, setUser] = useState({ firstName: '', lastName: '', email: '', password: '', birthDate: '' });
    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            await API.post('/auth/register', user);
            alert("Registration successful! Please login.");
            navigate('/login');
        } catch (err) {
            alert("Registration failed. Email might already be taken.");
        }
    };

    return (
        <div style={{ maxWidth: '400px', margin: '50px auto' }}>
            <h2>Create Account</h2>
            <form onSubmit={handleRegister}>
                <input type="text" placeholder="First Name" onChange={e => setUser({...user, firstName: e.target.value})} required /><br/>
                <input type="text" placeholder="Last Name" onChange={e => setUser({...user, lastName: e.target.value})} required /><br/>
                <input type="email" placeholder="Email" onChange={e => setUser({...user, email: e.target.value})} required /><br/>
                <input type="password" placeholder="Password" onChange={e => setUser({...user, password: e.target.value})} required /><br/>
                <input type="date" onChange={e => setUser({...user, birthDate: e.target.value})} required /><br/>
                <button type="submit">Register</button>
            </form>
            <p>Already have an account? <a href="/login">Login here</a></p>
        </div>
    );
};

export default Register;