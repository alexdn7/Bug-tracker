import React from 'react';
import {Link} from 'react-router-dom';
import './sidebar.css';

export default function Sidebar() {

    return (
        <div className='sidebar'>
            <Link className='nav-link' to="/">
                <h1 className='brand'>
                    Bug tracker
                </h1>
            </Link>
            <ul>
                <li>
                    <Link to='/' className='nav-link'>
                        Dashboard
                    </Link>
                </li>
                <li>
                    <Link to='/tickets/all' className='nav-link'>
                        View all tickets
                    </Link>
                </li>
                <li>
                    <Link to='/tickets/add' className='nav-link'>
                        Create a new ticket
                    </Link>
                </li>
                <button className='nav-link logout'>
                    Logout
                </button>
            </ul>
        </div>
    )
}