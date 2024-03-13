import { useParams } from "react-router-dom";
import { getProjectById } from "../services/ProjectService";
import { useState, useEffect } from "react";

export default function Project() {
  const [project, setProject] = useState(null);

  useEffect(() => {
    getAndSetProject();
  }, []);

  const { projectId } = useParams();

  function getAndSetProject() {
    getProjectById(projectId)
      .then((response) => {
        setProject(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
}
