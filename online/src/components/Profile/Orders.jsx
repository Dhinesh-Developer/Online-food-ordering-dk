import React from 'react';
import OrderCard from './OrderCard';

const Orders = () => {
  return (
    <div className="flex flex-col items-center px-4">
      {/* Title */}
      <h1 className="text-xl text-center py-7 font-semibold">My Orders</h1>

      {/* Orders List */}
      <div className="space-y-5 w-full lg:w-1/2">
        {[1, 1, 1, 1].map((item, index) => (
          <OrderCard key={index} />
        ))}
      </div>
    </div>
  );
};

export default Orders;
