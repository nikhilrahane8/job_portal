const API_URL = "/api/jobs";


// ================================
// GET ALL JOBS
// ================================

async function getJobs() {

    try {

        const response = await fetch("/api/all_jobs");

        if (!response.ok) {
            throw new Error("Failed to fetch jobs");
        }

        const jobs = await response.json();

        const jobsContainer =
            document.getElementById("jobs");

        jobsContainer.innerHTML = "";


        // No jobs
        if (jobs.length === 0) {

            jobsContainer.innerHTML = `
                <div class="empty-state">
                    <div>📭</div>
                    <h3>No jobs available</h3>
                    <p>Add your first job using the form above.</p>
                </div>
            `;

            return;
        }


        // Display jobs
        jobs.forEach(job => {

            jobsContainer.innerHTML += `

                <div class="job-card">

                    <div class="job-top">

                        <div class="job-icon">
                            💼
                        </div>

                        <span class="job-id">
                            #${job.id}
                        </span>

                    </div>


                    <h3>
                        ${job.title}
                    </h3>


                    <div class="job-info">
                    <div class="company-info">
                 <div class="company-logo">
            ${job.company.charAt(0).toUpperCase()}
         </div>

            <span>${job.company}</span>
            </div>

                        <div>
                            📍
                            <span>${job.location}</span>
                        </div>
                          

                        <div>
                            💰
                            <span class="salary">
                                ₹${Number(job.salary).toLocaleString("en-IN")}
                            </span>
                        </div>

                    </div>


                    <button
                        class="delete-button"
                        onclick="deleteJob(${job.id})">

                        Delete Job

                    </button>

                </div>

            `;
        });

    } catch (error) {

        console.error(error);

        document.getElementById("jobs").innerHTML = `

            <div class="empty-state">

                <div>⚠️</div>

                <h3>Unable to load jobs</h3>

                <p>
                    Make sure your Spring Boot application is running.
                </p>

            </div>

        `;
    }
}



// ================================
// POST - ADD JOB
// ================================

async function addJob() {

    const title =
        document.getElementById("title").value.trim();

    const location =
        document.getElementById("location").value.trim();

    const salary =
        document.getElementById("salary").value;
    
    const company =
        document.getElementById("company").value;


    const job = {

        title: title,

        location: location,

        salary: Number(salary),

        company: company

    };


    try {

        const response = await fetch(API_URL, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(job)

        });


        if (!response.ok) {

            throw new Error("Failed to create job");

        }


        const createdJob =
            await response.json();


        console.log("Created Job:", createdJob);


        alert(
            "Job created successfully! ID: "
            + createdJob.id
        );


        // Clear form

        document.getElementById("title").value = "";

        document.getElementById("location").value = "";

        document.getElementById("salary").value = "";

        document.getElementById("company").value ="";


        // Reload jobs

        getJobs();


    } catch (error) {

        console.error(error);

        alert("Failed to create job.");

    }

}



// ================================
// FORM SUBMIT
// ================================

document
    .getElementById("jobForm")
    .addEventListener("submit", function(event) {

        event.preventDefault();

        addJob();

    });



// ================================
// DELETE JOB
// ================================

async function deleteJob(id) {

    const confirmed =
        confirm("Are you sure you want to delete this job?");


    if (!confirmed) {
        return;
    }


    try {

        const response =
            await fetch(`/api/jobs/${id}`, {

                method: "DELETE"

            });


        if (!response.ok) {

            throw new Error("Delete failed");

        }


        alert("Job deleted successfully");


        getJobs();


    } catch (error) {

        console.error(error);

        alert("Failed to delete job.");

    }

}



// ================================
// LOAD JOBS ON PAGE LOAD
// ================================

getJobs();