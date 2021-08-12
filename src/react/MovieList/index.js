import React, {useState} from "react";
import "./index.css";

function MovieList() {
    const NO_RESULTS_FOUND = <div className="mt-50 slide-up-fade-in" data-testid="no-result">No Results Found</div>;
    // Declare search message
    const [message, setMessage] = useState("");
    // Declare movie data
    const [movies, setMovies] = useState([]);


    const search = () => {
        let input = document.getElementById("app-input");
        let url = 'https://jsonmock.hackerrank.com/api/movies?Year=' + input.value;
        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    let data = result["data"];
                    if (data.length > 0) {
                        setMovies(data);
                        setMessage("");
                    } else {
                        setMessage(NO_RESULTS_FOUND);;
                        setMovies([]);
                    }
                }
            );
    }

    return (
        <div className="layout-column align-items-center mt-50" >
            <section className="layout-row align-items-center justify-content-center">
                <input id="app-input" type="number" className="large" placeholder="Enter Year eg 2015" data-testid="app-input"/>
                <button onClick={search} className="" data-testid="submit-button">Search</button>
            </section>

            <ul className="mt-50 styled" data-testid="movieList">
                {movies.map((data) =>
                    <li key={data["imdbID"]} className="slide-up-fade-in py-10">{data["Title"]}</li>
                )}
            </ul>

            {message}
        </div>
    );
}

export default MovieList