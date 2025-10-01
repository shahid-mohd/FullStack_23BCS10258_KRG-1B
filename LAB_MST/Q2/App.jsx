import React, { useState, useEffect } from "react";

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  useEffect(() => {
    const savedTasks = JSON.parse(localStorage.getItem("tasks")) || [];
    setTasks(savedTasks);
  }, []);

  useEffect(() => {
    localStorage.setItem("tasks", JSON.stringify(tasks));
  }, [tasks]);

  const handleAddTask = () => {
    if (newTask.trim() === "") return;
    setTasks([...tasks, { text: newTask, completed: false }]);
    setNewTask("");
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleAddTask();
    }
  };

  const toggleTask = (index) => {
    const updatedTasks = [...tasks];
    updatedTasks[index].completed = !updatedTasks[index].completed;
    setTasks(updatedTasks);
  };

  const removeTask = (index) => {
    const updatedTasks = tasks.filter((_, i) => i !== index);
    setTasks(updatedTasks);
  };

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col">
      <header className="bg-blue-600 text-white py-6 shadow-md">
        <h1 className="text-3xl font-bold text-center">To-Do App</h1>
      </header>

      <main className="flex-1 flex flex-col items-center p-6">

        <div className="bg-white shadow-lg rounded-xl p-6 w-full max-w-md mb-6">
          <h2 className="text-xl font-semibold mb-4 text-gray-700">Add a New Task</h2>
          <div className="flex">
            <input
              type="text"
              placeholder="Enter a task..."
              value={newTask}
              onChange={(e) => setNewTask(e.target.value)}
              onKeyDown={handleKeyPress}
              className="flex-1 px-4 py-2 border rounded-l-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
            <button
              onClick={handleAddTask}
              className="bg-blue-500 text-white px-4 py-2 rounded-r-lg hover:bg-blue-600 transition"
            >
              Add Task
            </button>
          </div>
        </div>

        <div className="w-full max-w-md">
          {tasks.length === 0 && (
            <p className="text-gray-500 text-center">No tasks yet! Add one above.</p>
          )}
          {tasks.map((task, index) => (
            <div
              key={index}
              className="flex items-center justify-between bg-white p-3 mb-2 rounded-lg shadow-sm hover:shadow-md transition"
            >
              <div
                onClick={() => toggleTask(index)}
                className={`flex-1 cursor-pointer ${task.completed ? "line-through text-gray-400" : "text-gray-800"}`}
              >
                {task.text}
              </div>
              <button
                onClick={() => removeTask(index)}
                className="text-red-500 hover:text-red-700 font-medium ml-4"
              >
                Remove
              </button>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
}

export default App;
