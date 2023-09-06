import React from "react";
import './ticketForm.css';

export default function BugForm(props) {
    return (
        <div className="bug-create"> 
            <h1>{props.title}</h1>
            <form>
                <label>Name: </label>
                <input name='name' placeholder='Bug name' required></input>
                <label>Description:</label>
                <textarea name='description' placeholder='Description of the problem' required></textarea>
                <label>Priority:</label>
                <select name='priority' required>
                    <option value='1'>High</option>
                    <option value='2'>Medium</option>
                    <option value='3'>Low</option>
                </select>
                <button type='submit'>{props.title}</button>
            </form>
        </div>
    )
}