/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      transitionProperty: {
        'transform': 'transform',
        'opacity': 'opacity',
      },
      transform: {
        'scale-0': 'scale(0)',
        'scale-100': 'scale(1)',
      },
    },
  },
  plugins: [],
};
