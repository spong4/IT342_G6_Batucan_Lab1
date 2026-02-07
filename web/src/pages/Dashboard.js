import React, { useEffect, useState } from 'react';
import API from '../api';
import { useNavigate } from 'react-router-dom';

const Dashboard = () => {
    const [userData, setUserData] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const res = await API.get('/user/me');
                setUserData(res.data);
            } catch (err) {
                localStorage.removeItem('token');
                navigate('/login');
            }
        };
        fetchUser();
    }, [navigate]);

    const handleLogout = () => {
        localStorage.removeItem('token');
        navigate('/login');
    };

    if (!userData) return <p>Loading profile...</p>;

    return (
        <div style={{ padding: '20px' }}>
            <h1>Welcome, {userData.firstName}!</h1>
            <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px' }}>
                <p><strong>Full Name:</strong> {userData.firstName} {userData.lastName}</p>
                <p><strong>Email:</strong> {userData.email}</p>
                <p><strong>Birth Date:</strong> {userData.birthDate}</p>
            </div>
            <br/>
            <button onClick={handleLogout} style={{ backgroundColor: 'red', color: 'white' }}>Logout</button>
        </div>
    );
};

export default Dashboard;