import React from "react";

function App() {
  const ProductCart = ({ name, price, description, inStock }) => {
    return (
      <div className="bg-white shadow-md rounded-xl p-5 text-center">
        <h2 className="text-lg font-bold mb-2">{name}</h2>
        <p className="text-gray-600 mb-2">{description}</p>
        <p className="text-blue-600 font-semibold mb-4">₹{price}</p>
        {inStock ? (
          <button className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600">
            Buy Now
          </button>
        ) : (
          <p className="text-red-500 font-medium">Out of Stock</p>
        )}
      </div>
    );
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-6">
      <div className="grid gap-6 md:grid-cols-3">
        <ProductCart
          name="JBL Wireless Headphones"
          price={2999}
          description="High-quality sound with noise cancellation."
          inStock={true}
        />

        <ProductCart
          name="Apple Smart Watch"
          price={12999}
          description="Track your health and fitness with ease."
          inStock={false}
        />

        <ProductCart
          name="Sony Bluetooth Speaker"
          price={5999}
          description="Portable and powerful bass performance."
          inStock={true}
        />
      </div>
    </div>
  );
}

export default App;
