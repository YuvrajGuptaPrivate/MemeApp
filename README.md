# 📱 Meme App

An Android application built with **XML-based Views** that fetches memes from the [WholesomeMemeAPI](https://meme-api.com) and displays them in a **RecyclerView** with **infinite scrolling**.  

---

## 🚀 Features
- 📌 XML-based UI (RecyclerView, CardView, ImageView, ProgressBar)  
- 🌐 Fetch memes using **WholesomeMemeAPI**  
- 🔄 **Infinite scrolling** (no pagination) → maintains a list in `ViewModel` and appends new memes when the user reaches the bottom  
- 🧩 **MVVM architecture** with `ViewModel` + `LiveData`  
- ⚡ Image loading with **Glide/Coil**  

---

## 🏗️ How It Works
1. **Initial Load** → Fetch memes from the API.  
2. **ViewModel Storage** → Store fetched memes inside a `MutableLiveData<List<Meme>>`.  
3. **UI Update** → RecyclerView observes changes via LiveData and updates automatically.  
4. **Infinite Scroll** → On reaching the last item in the RecyclerView, fetch more memes and append them to the existing list.  

---

## 📂 Tech Stack
- **Language:** Kotlin  
- **UI:** Android XML  
- **Networking:** Retrofit2 + Gson  
- **Image Loading:** Glide  
- **Architecture:** MVVM (ViewModel + LiveData)  

---

## 🔧 Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/YuvrajGuptaPrivate/MemeApp.git
